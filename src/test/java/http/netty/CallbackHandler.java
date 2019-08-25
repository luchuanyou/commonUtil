package http.netty;

public interface CallbackHandler<T> {
    void failed(Exception e);

    void completed(T callback);

    void cancelled();
}
