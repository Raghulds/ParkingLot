package Models;

import java.time.LocalDateTime;
import java.util.UUID;

public class BaseModel {
    public LocalDateTime createdAt = LocalDateTime.now();
    public UUID uuid = UUID.randomUUID();

    public UUID getUuid() {
        return uuid;
    }
}
