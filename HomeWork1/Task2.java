public class Task2 {
    public static void main(String[] args)
    {
        String[] str={"aabb", "mafabbb","sasaabb"};
        String result=LongestCommonPrefix(str);
        if ( !result.isEmpty())
        {
            System.out.printf("Общий префикс массива: %s",result);  
        }
        else
        {
            System.out.println("Общего префикса нет"); 
        }
        
    }
    public static String LongestCommonPrefix(String[] str)
    {
        if (str.length == 0)
            return "";
        String prefix = str[0];
        for (String item : str)
        {
            while (item.indexOf(prefix) != 0)
            {
                prefix = prefix.substring(0, prefix.length() - 1); 
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix; 
    }
}
