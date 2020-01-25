public class SecurityAgent{
	private DoorLock doorProtected;
	private Combination secret;

	public SecurityAgent(){
		secret = new Combination(1,2,3);

		doorProtected=new DoorLock(secret);
	}

	public DoorLock getDoorLock(){
		return doorProtected;
	}

	public void activateDoorLock(){
		doorProtected.activate(secret);
	}
}