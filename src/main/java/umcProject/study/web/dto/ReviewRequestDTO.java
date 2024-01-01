package umcProject.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umcProject.study.validation.annotation.ExistStore;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDTO {
        @NotBlank
        String body;
        @NotNull
        Float score;
        @NotNull
        Long memberId;
        @ExistStore
        Long storeId;
    }
}
