import org.apache.ofbiz.entity.GenericEntityException

def createNewOrderHeaderGroovy() {
    def result = [:] // Use def to declare result as a local variable

    try {
        def newOrderHeader = delegator.makeValue("NewOrderHeader")
        newOrderHeader.setNextSeqId()

        newOrderHeader.setNonPKFields(context)
        newOrderHeader = delegator.create(newOrderHeader)

        result.orderId = newOrderHeader.orderId
        logInfo("==============>  This is my first Groovy Service implementation in Apache OFBiz. OfbizDemo record "
                + "created successfully with orderId: " + newOrderHeader.getString("orderId"))

    } catch (GenericEntityException e) {
        logError(e.getMessage())
        return error("Error in creating record in the NewOrderHeader entity..........") as Object
    }

    return result // Return the result map
}





//temp code
//import org.apache.ofbiz.entity.GenericEntityException;
//
//def createNewOrderHeaderGroovy() {
//    result = [:];
//    try {
//        ofbizDemo = delegator.makeValue("OfbizDemo");
//        // Auto generating next sequence of ofbizDemoId primary key
//        ofbizDemo.setNextSeqId();
//        // Setting up all non primary key field values from context map
//        ofbizDemo.setNonPKFields(context);
//        // Creating record in database for OfbizDemo entity for prepared value
//        ofbizDemo = delegator.create(ofbizDemo);
//        result.ofbizDemoId = ofbizDemo.ofbizDemoId;
//        logInfo("==========This is my first Groovy Service implementation in Apache OFBiz. OfbizDemo record "
//                +"created successfully with ofbizDemoId: "+ofbizDemo.getString("ofbizDemoId"));
//    } catch (GenericEntityException e) {
//        logError(e.getMessage());
//        return error("Error in creating record in OfbizDemo entity ........");
//    }
//    return result;
//}



