package no.uib.emi003.info233.v15.oblig2.data;

public class DataObjects {
	public String uibRoomIdentifier;
	public String uibBuildingIdentifier;
	public int uibRoomCapasity;
	public boolean uibRoomInService;
	
	public DataObjects(String roomIdentifier, String buildingIdentifer, int roomCapacity, boolean roomInService) {
		uibRoomIdentifier = roomIdentifier;
		uibBuildingIdentifier = buildingIdentifer;
		uibRoomCapasity = roomCapacity;
		uibRoomInService = roomInService;
		
	}

	public String getUibRoomIdentifier() {
		return uibRoomIdentifier;
	}

	public void setUibRoomIdentifier(String uibRoomIdentifier) {
		this.uibRoomIdentifier = uibRoomIdentifier;
	}

	public String getUibBuildingIdentifier() {
		return uibBuildingIdentifier;
	}

	public void setUibBuildingIdentifier(String uibBuildingIdentifier) {
		this.uibBuildingIdentifier = uibBuildingIdentifier;
	}

	public int getUibRoomCapasity() {
		return uibRoomCapasity;
	}

	public void setUibRoomCapasity(int uibRoomCapasity) {
		this.uibRoomCapasity = uibRoomCapasity;
	}

	public boolean isUibRoomInService() {
		return uibRoomInService;
	}

	public void setUibRoomInService(boolean uibRoomInService) {
		this.uibRoomInService = uibRoomInService;
	}
	
}
