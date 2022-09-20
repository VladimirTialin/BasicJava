public class UserStack<T> {
    private T[] array;
    private int index;
    
    public UserStack(int length) {
        if(length<=0){
			System.out.printf("Ошибка! Размер Stack не может принять значение %d\n",length);
		}
		else{
            this.index = 0;
            this.array = (T[]) new Object[length];
        }
    }

    public int size() {
        return this.index;
    }

    public boolean empty() {
        return this.size() == 0;
    }

    public void push(T value) {
        try{
             this.array[index++] = value;
        }
        catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
    }
   
    public T peek() {
        try{
            return this.array[index - 1];
        }
        catch(Exception ex)
        {
            System.out.println(ex.getLocalizedMessage());
            return null;
        }
    }
    public T pop(){
        try{
            return this.array[--index];
        }
        catch(Exception ex){
            System.out.println(ex.getLocalizedMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        UserStack<String> stack = new UserStack<>(4);
        stack.push("hello");
		stack.push("world");
		stack.push("I'm");
		stack.push("Vladimir");
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        System.out.println("Размер Stack: "+stack.size());
        System.out.println("Пустой ли Stack? "+stack.empty());
    }
}
