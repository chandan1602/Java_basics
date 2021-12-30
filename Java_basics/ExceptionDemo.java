class ExceptionDemo {
    public static void main(String ar[]) {
        
        try{
            for(int i=0; i<ar.length; i++){
            System.out.println(Integer.parseInt(ar[i]));
                
        }
        }catch(NumberFormatException e){
            // System.out.println(e.getMessage())
            e.printStackTrace();
        }

        
    }
}