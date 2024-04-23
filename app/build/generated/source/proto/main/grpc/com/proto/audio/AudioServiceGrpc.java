package com.proto.audio;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: audio.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AudioServiceGrpc {

  private AudioServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "AudioService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.audio.Audio.DownloadFileRequest,
      com.proto.audio.Audio.DataChunkResponse> getDownloadAudioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "downloadAudio",
      requestType = com.proto.audio.Audio.DownloadFileRequest.class,
      responseType = com.proto.audio.Audio.DataChunkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.audio.Audio.DownloadFileRequest,
      com.proto.audio.Audio.DataChunkResponse> getDownloadAudioMethod() {
    io.grpc.MethodDescriptor<com.proto.audio.Audio.DownloadFileRequest, com.proto.audio.Audio.DataChunkResponse> getDownloadAudioMethod;
    if ((getDownloadAudioMethod = AudioServiceGrpc.getDownloadAudioMethod) == null) {
      synchronized (AudioServiceGrpc.class) {
        if ((getDownloadAudioMethod = AudioServiceGrpc.getDownloadAudioMethod) == null) {
          AudioServiceGrpc.getDownloadAudioMethod = getDownloadAudioMethod =
              io.grpc.MethodDescriptor.<com.proto.audio.Audio.DownloadFileRequest, com.proto.audio.Audio.DataChunkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "downloadAudio"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.audio.Audio.DownloadFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.audio.Audio.DataChunkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AudioServiceMethodDescriptorSupplier("downloadAudio"))
              .build();
        }
      }
    }
    return getDownloadAudioMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AudioServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AudioServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AudioServiceStub>() {
        @java.lang.Override
        public AudioServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AudioServiceStub(channel, callOptions);
        }
      };
    return AudioServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AudioServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AudioServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AudioServiceBlockingStub>() {
        @java.lang.Override
        public AudioServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AudioServiceBlockingStub(channel, callOptions);
        }
      };
    return AudioServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AudioServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AudioServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AudioServiceFutureStub>() {
        @java.lang.Override
        public AudioServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AudioServiceFutureStub(channel, callOptions);
        }
      };
    return AudioServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void downloadAudio(com.proto.audio.Audio.DownloadFileRequest request,
        io.grpc.stub.StreamObserver<com.proto.audio.Audio.DataChunkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDownloadAudioMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AudioService.
   */
  public static abstract class AudioServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AudioServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AudioService.
   */
  public static final class AudioServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AudioServiceStub> {
    private AudioServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AudioServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AudioServiceStub(channel, callOptions);
    }

    /**
     */
    public void downloadAudio(com.proto.audio.Audio.DownloadFileRequest request,
        io.grpc.stub.StreamObserver<com.proto.audio.Audio.DataChunkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getDownloadAudioMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AudioService.
   */
  public static final class AudioServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AudioServiceBlockingStub> {
    private AudioServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AudioServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AudioServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.proto.audio.Audio.DataChunkResponse> downloadAudio(
        com.proto.audio.Audio.DownloadFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getDownloadAudioMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AudioService.
   */
  public static final class AudioServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AudioServiceFutureStub> {
    private AudioServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AudioServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AudioServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DOWNLOAD_AUDIO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DOWNLOAD_AUDIO:
          serviceImpl.downloadAudio((com.proto.audio.Audio.DownloadFileRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.audio.Audio.DataChunkResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getDownloadAudioMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.proto.audio.Audio.DownloadFileRequest,
              com.proto.audio.Audio.DataChunkResponse>(
                service, METHODID_DOWNLOAD_AUDIO)))
        .build();
  }

  private static abstract class AudioServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AudioServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.audio.Audio.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AudioService");
    }
  }

  private static final class AudioServiceFileDescriptorSupplier
      extends AudioServiceBaseDescriptorSupplier {
    AudioServiceFileDescriptorSupplier() {}
  }

  private static final class AudioServiceMethodDescriptorSupplier
      extends AudioServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AudioServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AudioServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AudioServiceFileDescriptorSupplier())
              .addMethod(getDownloadAudioMethod())
              .build();
        }
      }
    }
    return result;
  }
}
