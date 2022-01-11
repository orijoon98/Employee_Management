package com.fleta.employee.service;

import com.fleta.employee.entity.PrivateInformation;
import com.fleta.employee.entity.PublicInformation;
import com.fleta.employee.entity.User;
import com.fleta.employee.repository.PrivateInformationRepository;
import com.fleta.employee.repository.PublicInformationRepository;
import com.fleta.employee.repository.UserRepository;
import com.fleta.employee.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PublicInformationRepository publicInformationRepository;
    private final PrivateInformationRepository privateInformationRepository;
    private final JwtUtil jwtUtil;

    public void updateUserPublic(String token, String country, LocalDate birthday, String gender, String zipCode, String address, String detailAddress, String number, String phoneNumber) {
        String loginId = jwtUtil.getLoginId(token);
        Optional<User> user = userRepository.findByLoginId(loginId);

        PublicInformation publicInformation = user.get().getPublicInformation();

        publicInformation.setCountry(country);
        publicInformation.setBirthday(birthday);
        publicInformation.setGender(gender);
        publicInformation.setZipCode(zipCode);
        publicInformation.setAddress(address);
        publicInformation.setDetailAddress(detailAddress);
        publicInformation.setNumber(number);
        publicInformation.setPhoneNumber(phoneNumber);
        publicInformation.setUpdatedAt(LocalDateTime.now());

        publicInformationRepository.save(publicInformation);
    }

    public void updateUserPrivate(String token, String bank, String accountNumber, String accountHolder, String note) {
        String loginId = jwtUtil.getLoginId(token);
        Optional<User> user = userRepository.findByLoginId(loginId);

        PrivateInformation privateInformation = user.get().getPrivateInformation();

        privateInformation.setBank(bank);
        privateInformation.setAccountNumber(accountNumber);
        privateInformation.setAccountHolder(accountHolder);
        privateInformation.setNote(note);
        privateInformation.setUpdatedAt(LocalDateTime.now());

        privateInformationRepository.save(privateInformation);

    }
}
