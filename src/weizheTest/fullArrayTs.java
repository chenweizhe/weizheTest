package weizheTest;


public class fullArrayTs {
	
	public static void Prem(int n){
		int a[] = new int[n];
		boolean dir[] = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = 1+i;
			dir[i] = false; //flase为左，true为右
		}
		do {
			print2(a,dir,n);
			if(n == a[n-1]){
				for(int i = n-1; i>0 ; i--){
					int temp = a[i]; 
					a[i] = a[i-1]; 
					a[i-1] = temp;
					
					boolean flag = dir[i];
					dir[i] = dir[i-1]; 
					dir[i-1] = flag;
					
					print2(a,dir, n);
				}
			}else {
				for(int i=1;i<n;i++){
					int temp = a[i];
					a[i] = a[i-1]; 
					a[i-1] = temp;

					boolean flag = dir[i];
					dir[i] = dir[i-1]; 
					dir[i-1] = flag;
					print2(a, dir, n);
				}
			}
		} while (MaxMove(a,dir,n));
	}

	public static boolean MaxMove(int[] a, boolean[] dir, int n) {
		int max = 1;	
		int pos = -1;
		
		for(int i=0;i<n;i++){
			if(a[i]<max)
				continue;
			if ((dir[i] && i < n-1 && a[i] > a[i+1]) || (!dir[i] && i > 0 && a[i] > a[i-1])) {
				max = a[i];
				pos = i;
			}
		}
		if (pos == -1)
			return false;
		if (dir[pos]) {
			int temp = a[pos];
			a[pos] = a[pos+1]; 
			a[pos+1] = temp;
			
			boolean flag = dir[pos];
			dir[pos] = dir[pos+1]; 
			dir[pos+1] = flag;
			
		}else {
			   int temp = a[pos];
			   a[pos] = a[pos-1]; 
			   a[pos-1] = temp;

			   boolean flag = dir[pos];
			   dir[pos] = dir[pos-1]; 
			   dir[pos-1] = flag;
		}
		
		for (int i = 0; i < n; i++) {
			 if (a[i] > max)
				 dir[i] = !dir[i];
		}
		
		return true;
	}

	public static void print2(int a[],boolean dir[],int n){
		for (int i = 0; i < n; i++) {
			if (dir[i] == false)
				System.out.print("<—"+" ");
			else if (dir[i] == true)
				System.out.print("—>"+" ");
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int n = 4;
		Prem(n);
	}
	
	
	
	
	

}
