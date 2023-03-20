package com.sungjin.jobfair.userInfoModiService;

import com.sungjin.jobfair.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userModiService")
public class UserModiServiceImpl implements UserModiService {

    @Autowired
    public PasswordEncoder pwEncoder;

    @Autowired
    public UserModiMapper userModiMapper;

    //user 정보 조회
    @Override
    public UserVO getUserInfo(UserVO vo) {
        return userModiMapper.getUserInfo(vo);
    }

    //회원정보 변경
    @Override
    public void modifyInfo(UserVO vo) {
        userModiMapper.modifyInfo(vo);
    }

    //비밀번호 변경 요청
    @Override
    public String modifyPw(UserVO vo) {

        String currentPw = vo.getCurrentPw(); // 입력된 현재 비밀번호
        String encodePw = userModiMapper.getEncodePw(vo); //db속 암호화된 비밀번호
        String newPw = vo.getNewPw();

        // 입력된 현재 비밀번호 , db의 비밀번호 비교해서 분기처리
        if(true == pwEncoder.matches(currentPw, encodePw)){

            //새로운 비밀번호와 현재 비밀번호가 동일하면 안됨
            if(currentPw.equals(newPw)){
                return "현재 비밀번호를 신규 비밀번호로 사용할 수 없습니다";
            } else {
                //새로운 비밀번호로 변경 가능, 먼저 변경할 비밀번호 암호화 필요
                String newEncodePw = pwEncoder.encode(newPw);
                vo.setNewPw(newEncodePw);

                //암호화된 새 비밀번호로 비밀번호 변경
                userModiMapper.modifyPw(vo);
                return "비밀번호가 변경되었습니다";
            }

        } else {
            return "기존 비밀번호가 틀렸습니다";
        }
    }
}