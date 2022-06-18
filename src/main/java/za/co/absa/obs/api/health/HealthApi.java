package za.co.absa.obs.api.health;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api"+ HealthApi.ENDPOINT)
public class HealthApi {

    public static final String ENDPOINT = "/health";
    public static final String VERSION = "/version";

    BuildProperties buildProperties;

    @Autowired
    public HealthApi(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @GetMapping(path = HealthApi.VERSION)
    public String getAppVersion() {
        return "Version: " + buildProperties.getVersion() + ", Build @ " + buildProperties.getTime();
    }
}
