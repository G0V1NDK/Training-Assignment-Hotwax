package com.companyname.ofbizdemo.services;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;

import java.util.Map;

public class OfbizDemoServices {

    //??
    public static final String module = OfbizDemoServices.class.getName();
    public static Map<String, Object> createNewOrderHeader(DispatchContext dctx, Map<String, ? extends Object> ctx){
        Map<String, Object> result = ServiceUtil.returnSuccess(); //??
        Delegator delegator = dctx.getDelegator();

        try{
            GenericValue newOrderHeader = delegator.makeValue("NewOrderHeader");
            newOrderHeader.setNextSeqId();

            newOrderHeader.setNonPKFields(ctx);
            newOrderHeader = delegator.create(newOrderHeader);

            result.put("orderId", newOrderHeader.getString("orderId"));

//            Debug.log("MapValue is ====>  " + result.get("orderId"));
////            System.out.println("Delegator: " + delegator);
////            System.out.println("orderHeader" + newOrderHeader);
//
////            System.out.println("Maps: ");
//            for (Map.Entry<String, Object> entry: result.entrySet()){
////                System.out.println(entry.getKey() + ", " + entry.getValue().toString());
//                // How to print the object value of the map??
//                Debug.log(entry.getKey() + "<==============================================> " + entry.getValue());
//            }


            Debug.log("Created first java service in ofbiz on NewOrderHeader ======> orderID: " + newOrderHeader.getString("orderId"));

        }catch (GenericEntityException e){
            Debug.logError(e, module);
            return  ServiceUtil.returnError("Error in Creating NewOrderHeader Entity" + module);
        }

        return result;
    }

}