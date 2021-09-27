package co.edu.platform.model.modalities;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Modalities {
    private final  int idModality;
    private final  String modalityName;
}
