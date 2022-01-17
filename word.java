public class word{
  public String key;
  private boolean status;
  public int length;
  public word(String s){
    key = s; 
    this.length = key.length();
    status = true;
  }
  public boolean getStatus(){
    return status;
  }
  public boolean legit(String s){
    return s.length() == key.length();
  }
  public void display(String s){
    for(int i = 0 ; i < s.length() ; i ++){
      if((s.substring(i, i+1)).equals(key.substring(i, i+1))){
        System.out.print(s.substring(i, i+1)+"! ");
      }
      else if(key.indexOf(s.substring(i, i+1)) != -1){
        System.out.print(s.substring(i, i+1)+"? ");
      }
      else{
        System.out.print(s.substring(i, i+1)+"* ");
      }
    }
    if(s.equals(key)) status = false;
    if(getStatus()) System.out.println(" Come on! Have another shot!");
    else System.out.println(" Hooooray! You got this!");
  }
}