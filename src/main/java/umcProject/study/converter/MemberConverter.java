package umcProject.study.converter;

import umcProject.study.domain.Member;
import umcProject.study.domain.enums.Gender;
import umcProject.study.web.dto.MemberRequestDTO;
import umcProject.study.web.dto.MemberResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static umcProject.study.domain.enums.Gender.*;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request) {

        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = MALE;
                break;
            case 2:
                gender = FEMALE;
                break;
            case 3:
                gender = NONE;
                break;
        }

        LocalDate birthday = LocalDate.of(request.getBirthYear(), request.getBirthMonth(), request.getBirthDay());

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .birthday(birthday)
                .memberPreferList(new ArrayList<>())
                .build();

    }
}
