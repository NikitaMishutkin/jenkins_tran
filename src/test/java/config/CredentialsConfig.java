package config;
import org.aeonbits.owner.Config;
@Config.Sources("classpath:config/credentials.propertise")
public interface CredentialsConfig extends Config {
    String login();
    String password();
}
