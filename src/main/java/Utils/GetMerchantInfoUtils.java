package Utils;

import Models.Response.GetMerchantInfoResponseModel;
import restWrapper.Headers;
import restWrapper.RestWrapper;
import static restWrapper.RestWrapper.Merchant_info_endPoint;

public class GetMerchantInfoUtils {

    public static GetMerchantInfoResponseModel getMerchantInfo(){
        return RestWrapper.restGet(Merchant_info_endPoint, Headers.GeneralHeader(), GetMerchantInfoResponseModel.class);
    }

}
