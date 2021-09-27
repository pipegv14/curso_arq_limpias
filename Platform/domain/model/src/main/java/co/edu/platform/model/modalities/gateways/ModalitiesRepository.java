package co.edu.platform.model.modalities.gateways;

import co.edu.platform.model.modalities.Modalities;

public interface ModalitiesRepository {

    public Modalities insertModality(int id, String name);
    public Modalities getById(int id);

}
