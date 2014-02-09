import java.util.ArrayList;
import java.io.*;
public class BakeSale {
	private ArrayList<FoodItem> menu;
	private ArrayList<String> staff;
	int owner;
	String ownername;
	int subindex;
	private String location;
	public BakeSale(int owner,int subindex,String location,String ownername)
	{
		this.owner=owner;
		readInfo(owner,subindex);
		this.location=location;
		this.subindex=subindex;
		this.ownername=ownername;
	}
	public ArrayList<FoodItem> getMenu()
	{
		return menu;
	}
	public ArrayList<String> getStaff()
	{
		return staff;
	}
	public int getOwner()
	{
		return owner;
	}
	public int getSubIndex()
	{
		return subindex;
	}
	public void setMenu(ArrayList<FoodItem> newmenu)
	{
		menu=newmenu;
		writeInfo();
	}
	public void setStaff(ArrayList<String> newstaff)
	{
		staff=newstaff;
		writeInfo();
	}
	public void setLocation(String newlocation)
	{
		location=newlocation;
	}
	public String getLocation()
	{
		return location;
	}
	public void readInfo(int owner,int subindex)
	{
		try
		{
			menu=new ArrayList<FoodItem>();
			staff=new ArrayList<String>();
			if (new File(Integer.toString(owner)+" "+Integer.toString(subindex)+".txt").exists())
			{
				BufferedReader bf=new BufferedReader(new FileReader(Integer.toString(owner)+" "+Integer.toString(subindex)+".txt"));
				String line;
				owner=Integer.parseInt(bf.readLine());
				ownername=bf.readLine();
				location=bf.readLine();
				while (!(line=bf.readLine()).equals("!@#NEWSTUFF!@#"))
					menu.add(FoodItem.parseItem(line));
				while ((line=bf.readLine())!=null)
					staff.add(line);
				bf.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void writeInfo()
	{
		try
		{
			FileWriter fw=new FileWriter(new File(owner+" "+subindex+".txt"));
			fw.write(owner+"\n");
			fw.write(ownername+"\n");
			fw.write(location+"\n");
			for (FoodItem f:menu)
			{
				fw.write(f.toString());
				fw.write("\n");
			}
			fw.write("!@#NEWSTUFF!@#");
			for (String s:staff)
				fw.write(s);
			fw.flush();
			fw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void addMenuItem(String item)
	{
		FoodItem temp=FoodItem.parseItem(item);
		for (FoodItem f:menu)
		{
			if (f.equalsOther(temp))
			{
				f.increaseQuantity(temp.getQuantity());
				writeInfo();
				return;
			}
		}
		menu.add(temp);
		writeInfo();
	}
	public void removeMenuItem(String item)
	{
		int temp=menu.indexOf(FoodItem.parseItem(item));
		if (temp!=-1)
			menu.remove(temp);
		writeInfo();
	}
	public void addStaffMember(String member)
	{
		if (!staff.contains(member))
			staff.add(member);
		writeInfo();
	}
	public void removeStaffMember(String member)
	{
		int temp=menu.indexOf(member);
		if (temp!=-1)
			staff.remove(temp);
		writeInfo();
	}
}