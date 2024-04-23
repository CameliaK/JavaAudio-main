package javaaudio.cliente;
import com.proto.audio.AudioServiceGrpc;
import com.proto.audio.Audio.DownloadFileRequest;
import com.proto.audio.AudioServiceGrpc.AudioServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 9090;
        String nombre;
        ManagedChannel ch = ManagedChannelBuilder.forAddress(host, puerto).usePlaintext().build();

        //nombre = "sample.wav";
        //streamWav(ch, nombre, 44100F);

        nombre = "anyma.wav";
        streamWav(ch, nombre, 48000F);

        //nombre = "tiesto.mp3";
        ByteArrayInputStream streamMP3 = downloadFile(ch, nombre);

        playMp3(streamMP3, nombre);
        try {
            streamMP3.close();
        } catch (IOException e) {
        }

        // Solicita archivo WAV al servidor
        /*nombre = "sample.wav";
        ByteArrayInputStream streamWAV = downloadFile(ch, nombre);

        // Reproduce
        playWav(streamWAV, nombre);
        try {
            streamWAV.close();
        } catch (IOException e) {
        }*/

        System.out.println("Apagando...");
        ch.shutdown();
    }

    public static void streamWav(ManagedChannel ch, String nombre, float sampleRate) {
        try {
            // AudioFormat (float sampleRate, int sampleSizeInBits, int channels, boolean signed, boolean bigEndian)
            AudioFormat newFormat = new AudioFormat(sampleRate, 16, 2, true, false);
            SourceDataLine sourceDataLine = AudioSystem.getSourceDataLine(newFormat);
            sourceDataLine.open(newFormat);
            sourceDataLine.start();
            AudioServiceBlockingStub stub = AudioServiceGrpc.newBlockingStub(ch);
            DownloadFileRequest peticion = DownloadFileRequest.newBuilder().setNombre(nombre).build();
            int bufferSize = 1024;
            System.out.println("Reproduciendo el archivo: " + nombre);

            stub.downloadAudio(peticion).forEachRemaining(respuesta -> {
                try {
                   sourceDataLine.write(respuesta.getData().toByteArray(), 0, bufferSize);
                   System.out.print("."); 
                } catch (Exception e) {
                }
            });

            System.out.println("\nRecepción de datos correcta");
            System.out.println("Reproducción terminada. \n\n");

            sourceDataLine.drain();
            sourceDataLine.close();

        } catch (LineUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ByteArrayInputStream downloadFile(ManagedChannel ch, String nombre) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        AudioServiceBlockingStub stub = AudioServiceGrpc.newBlockingStub(ch);

        DownloadFileRequest peticion = DownloadFileRequest.newBuilder().setNombre(nombre).build();

        System.out.println("Recibiendo el archivo: " + nombre);
        stub.downloadAudio(peticion).forEachRemaining(repsuesta -> {
            try {
                stream.write(repsuesta.getData().toByteArray());
                System.out.print(".");
            } catch (Exception e) {
                System.out.println("No se pudo obtener el archivo de audio.");
            }
        });

        System.out.println("\nRecepción de datos correcta.\n\n");

        return new ByteArrayInputStream(stream.toByteArray());
    }

    public static void playWav(ByteArrayInputStream inStream, String nombre) {
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(inStream);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            System.out.println("Reproduciendo el archivo: " + nombre + "...\n\n");
            clip.start();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clip.stop();

        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playMp3(ByteArrayInputStream inStream, String nombre) {
        try {
            System.out.println("Reproduciendo el archivo: " + nombre + "...\n");
            Player player = new Player(inStream);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
