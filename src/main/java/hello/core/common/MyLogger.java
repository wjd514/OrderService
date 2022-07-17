package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requsetURL;

    public void setRequsetURL(String requsetURL) {
        this.requsetURL = requsetURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requsetURL + "]" + message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"] request scope bean create: " + this );
    }

    @PreDestroy법
    public void close(){
        System.out.println("["+uuid+"] request scope bean close: " + this );
    }
}
