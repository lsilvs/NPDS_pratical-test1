package Fundraising;

/**
* Fundraising/CharityHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from donation.idl
* Wednesday, November 6, 2013 11:37:21 AM GMT
*/

public final class CharityHolder implements org.omg.CORBA.portable.Streamable
{
  public Fundraising.Charity value = null;

  public CharityHolder ()
  {
  }

  public CharityHolder (Fundraising.Charity initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Fundraising.CharityHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Fundraising.CharityHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Fundraising.CharityHelper.type ();
  }

}
