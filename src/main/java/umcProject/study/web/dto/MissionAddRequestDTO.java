package umcProject.study.web.dto;

import lombok.Getter;
import umcProject.study.validation.annotation.ExistStore;

import java.time.LocalDate;

public class MissionAddRequestDTO {

    @Getter
    public static class AddDTO {
        Integer reward;
        LocalDate deadline;
        String missionSpec;
        @ExistStore
        Long storeId;
    }
}
