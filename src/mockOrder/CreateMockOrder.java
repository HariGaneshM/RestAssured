package mockOrder;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import mockAPIpojo.AdvancePrescription;
import mockAPIpojo.Appeal;
import mockAPIpojo.BaseData;
import mockAPIpojo.DrugDetails;
import mockAPIpojo.MockAPI;
import mockAPIpojo.PatientDetails;

public class CreateMockOrder {

	public static void main(String[] args) {
		
		MockAPI payload = new MockAPI();
		BaseData baseData = new BaseData();
		baseData.setProgramType("Bausch");
		DrugDetails drugDetails = new DrugDetails();
		PatientDetails pd = new PatientDetails();
		baseData.setDrugDetails(drugDetails);
		baseData.setPatientDetails(pd);
		AdvancePrescription adv = new AdvancePrescription();
		Appeal app = new Appeal();
		adv.setAppeal(app);
		
		payload.setBaseData(baseData);
		payload.setAdvancePrescription(adv);
		
		given()
		   .contentType(ContentType.JSON)
		   .headers("Authorization", "PhilKey 9e5903c77e31490caf2160872b7dcfdb")
		   .body(payload)
		   .log()
		   .all()
		   .when()
		   .post("https://capi.dev.phil.us/_internal/thanos/v1/mock/order")
		   .then()
		   .log()
		   .all();
	}
}
