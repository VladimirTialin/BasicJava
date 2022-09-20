class UserQueue<T> {
    private T[] queue;
    private int index;
	private int count; 
 
    public UserQueue(int length) {
		if(length<=0){
			System.out.printf("Ошибка! Размер очереди не может принять значение %d\n",length);
		}
		else{
		this.queue= (T[]) new Object[length];
        index = 0;
		count=0;
	    }
	}

	public int size() {
		return this.index;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	} 

	public boolean offer(T value) {
		try{
			queue[index]=value; 
			index++;
			return true;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getLocalizedMessage());
			return false;
		}
	}

	public T poll() {
		if(isEmpty()) return null;
		T temp=queue[count++];
		index--;
		return temp;
	}

	public T peek() {
		try{
		return this.queue[count];
		}
		catch (Exception  ex){
			return null;
		}
		
	}
	public static void main(String[] args) {
		UserQueue <String> queue = new UserQueue<String>(4);
		queue.offer("hello");
		queue.offer("world");
		queue.offer("I'm");
		queue.offer("Vladimir");
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println("Первый элемент очереди: "+queue.peek());
		System.out.println("Размер очереди: "+queue.size());
		System.out.println("Очередь пустая? "+queue.isEmpty());
	 
		}
}