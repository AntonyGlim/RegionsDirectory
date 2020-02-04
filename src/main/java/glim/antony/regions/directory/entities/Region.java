package glim.antony.regions.directory.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Region {
    private int code;
    private String title;
    private String iso;

    public Region(int code, String title, String iso) {
        this.code = code;
        this.title = title;
        this.iso = iso;
    }
}
