package cn.wjs;

public class smstest {
}

//
//    @GetMapping("/aaa")
//    public RespBody<SMSGenerateVo> aaa() {
//        SMSGenerateDto smsGenerateDto = new SMSGenerateDto();
//        smsGenerateDto.setFromSys("TEST_SYS");
//        smsGenerateDto.setTransId("7f3c72bd-3fcf-491d-9d8d-66b786659875");
//        smsGenerateDto.setTransTime("20191102111528");
//        SMSGenerateDataDto data = new SMSGenerateDataDto();
//        data.setMobile("18701124264");
//        data.setIp("127.0.0.1");
//        smsGenerateDto.setData(data);
//        RespBody result = new RespBody();
//        result = smsService.SMSGenerate(smsGenerateDto);
//        return result;
//    }
//
//    @GetMapping("/bbb")
//    public RespBody<SMSGenerateVo> bbb() {
//        SMSGenerateDto smsGenerateDto = new SMSGenerateDto();
//        smsGenerateDto.setFromSys("TEST_SYS");
//        smsGenerateDto.setTransId("7f3c72bd-3fcf-491d-9d8d-66b786659875");
//        smsGenerateDto.setTransTime("20191102111528");
//        SMSGenerateDataDto data = new SMSGenerateDataDto();
//        data.setMobile("18701124264");
//        data.setIp("127.0.0.1");
//        data.setCode("0000");
//        data.setCodeId("644201339781382144");
//        smsGenerateDto.setData(data);
//        RespBody result = new RespBody();
//        result = smsService.SMSValidate(smsGenerateDto);
//        return result;
//    }
//
//    @GetMapping("/ccc")
//    public RespBody<SMSGenerateVo> ccc() {
//
//
//        SMSAuthenticateDto smsGenerateDto = new SMSAuthenticateDto();
//        smsGenerateDto.setFromSys("TEST_SYS");
//        smsGenerateDto.setTransId("7f3c72bd-3fcf-491d-9d8d-66b786659875");
//        smsGenerateDto.setTransTime("20191102111528");
//        SMSAuthenticateDataDto data = new SMSAuthenticateDataDto();
//        data.setToken("91fb18a1c4b94eeea317ed449a437696");
//        data.setAuthenticate("964340d51f034e81bd075318788f3d32");
//        smsGenerateDto.setData(data);
//        RespBody result = new RespBody();
//        result = smsService.verificationCode(smsGenerateDto);
//        return result;
//
//    }
//
//
//    @GetMapping("/ddd")
//    public RespBody<SMSGenerateVo> ddd() {
//
//
//        SMSAuthenticateDto smsGenerateDto = new SMSAuthenticateDto();
//        smsGenerateDto.setFromSys("TEST_SYS");
//        smsGenerateDto.setTransId("7f3c72bd-3fcf-491d-9d8d-66b786659875");
//        smsGenerateDto.setTransTime("20191102111528");
//        SMSAuthenticateDataDto data = new SMSAuthenticateDataDto();
//        data.setToken("91fb18a1c4b94eeea317ed449a437696");
//        data.setAuthenticate("964340d51f034e81bd075318788f3d32");
//        smsGenerateDto.setData(data);
//        RespBody result = new RespBody();
//        result = smsService.manualVerificationCode(smsGenerateDto);
//        return result;
//
//    }