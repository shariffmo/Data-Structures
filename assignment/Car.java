package assign_3_4;

/* @author Shariff Mohammed & Justin Lee
 */
 
public class Car 
{
	 String registration;
	 String name;
	
	public Car(String reg, String carName)
	{
		this.registration = reg;
		this.name = carName;
	}
	
	public void setKey(String key)
	{
		registration = key;
	}
	public void setName(String carName)
	{
		name = carName;
	}
	
	public String getKey()
	{
		return registration;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public String toString() 
	{
		return "Key:"+registration+" Value:"+name;
	}
	
	
}
