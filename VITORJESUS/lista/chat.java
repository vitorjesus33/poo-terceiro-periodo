import javax.websocket.*;
import java.net.URI;

@ClientEndpoint
public class ChatClient {
    private static final String SERVER_URI = "ws://localhost:8080/chat"; 

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Conectado ao servidor WebSocket!");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Mensagem recebida: " + message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.err.println("Erro: " + throwable.getMessage());
    }

    public static void main(String[] args) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(ChatClient.class, URI.create(SERVER_URI));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}