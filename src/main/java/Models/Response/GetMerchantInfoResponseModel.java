package Models.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMerchantInfoResponseModel {

        public float merchantId;
        public String name;
        public String nameArabic;
        public float cityId;
        public String cityName;
        public float bankId;
        public String bankName;
        public String address;
        public String addressArabic;
        public String contactPerson;
        public String contactNumber;
        public String email;
        public String commercialRegistrationNumber;
        public float vatPercent;
        public float madaFee;
        public float creditCardFee;
        public float status;
        public float merchantType;
        public boolean isVerified;
        public String salesAgentName = null;
        public String salesAgentPhone = null;
        public String salesAgentEmail = null;
        public float totalTerminals;
        public float activeTerminals;
        public String terminals = null;
        public String merchantBankName;
        public String merchantBankAccountNumber;
        public String merchantIBAN;
        public String merchantAccountName;

//    @JsonIgnoreProperties(ignoreUnknown = true)
//    public static class Root{
//        public int merchantId;
//        public String name;
//        public String nameArabic;
//        public int cityId;
//        public String cityName;
//        public int bankId;
//        public String bankName;
//        public String address;
//        public String addressArabic;
//        public String contactPerson;
//        public String contactNumber;
//        public String email;
//        public String commercialRegistrationNumber;
//        public double vatPercent;
//        public double madaFee;
//        public double creditCardFee;
//        public int status;
//        public int merchantType;
//        public boolean isVerified;
//        public Object salesAgentName;
//        public Object salesAgentPhone;
//        public Object salesAgentEmail;
//        public int totalTerminals;
//        public int activeTerminals;
//        public Object terminals;
//        public String merchantBankName;
//        public String merchantBankAccountNumber;
//        public String merchantIBAN;
//        public String merchantAccountName;
//    }


}
