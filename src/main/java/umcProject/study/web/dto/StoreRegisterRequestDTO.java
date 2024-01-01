package umcProject.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umcProject.study.validation.annotation.ExistCategory;
import umcProject.study.validation.annotation.ExistRegion;

public class StoreRegisterRequestDTO {

    @Getter
    public static class RegisterDTO {
        @NotBlank
        String name;
        @Size(min = 5, max = 12)
        String address;
        @ExistCategory
        Long categoryId;
        @ExistRegion
        Long regionId;
    }
}
