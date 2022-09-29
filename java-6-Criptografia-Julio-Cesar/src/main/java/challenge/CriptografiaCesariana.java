package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        if(texto.isEmpty()) {
            throw new IllegalArgumentException("Texto vazio");
        }

        String textoOriginal = texto.toLowerCase();
        char arrayTextoOriginal[] = textoOriginal.toCharArray();
        char arrayTextoCriptografado[] = new char[arrayTextoOriginal.length];

        for(int i=0; i < arrayTextoOriginal.length; i++){
            switch (arrayTextoOriginal[i]){
                case 'x':
                    arrayTextoCriptografado[i] = 'a';
                    break;
                case 'y':
                    arrayTextoCriptografado[i] = 'b';
                    break;
                case 'z':
                    arrayTextoCriptografado[i] = 'c';
                    break;
                case ' ':
                    arrayTextoCriptografado[i] = ' ';
                    break;
                default:
                    if(Character.isDigit(arrayTextoOriginal[i])){
                        arrayTextoCriptografado[i] = arrayTextoOriginal[i];
                    } else {
                        char newChar = (char) ((int)arrayTextoOriginal[i] + 3);
                        arrayTextoCriptografado[i] = newChar;
                    }
            }
        }
        String textoCriptografado =  new String(arrayTextoCriptografado);

        return textoCriptografado;
    }

    @Override
    public String descriptografar(String texto) {
        if(texto.isEmpty()) {
            throw new IllegalArgumentException("Texto vazio");
        }
        String textoOriginal = texto.toLowerCase();
        char arrayTextoOriginal[] = textoOriginal.toCharArray();
        char arrayTextoDescriptografado[] = new char[arrayTextoOriginal.length];

        for(int i=0; i < arrayTextoOriginal.length; i++){
            switch (arrayTextoOriginal[i]){
                case 'a':
                    arrayTextoDescriptografado[i] = 'x';
                    break;
                case 'b':
                    arrayTextoDescriptografado[i] = 'y';
                    break;
                case 'c':
                    arrayTextoDescriptografado[i] = 'z';
                    break;
                case ' ':
                    arrayTextoDescriptografado[i] = ' ';
                    break;
                default:
                    if(Character.isDigit(arrayTextoOriginal[i])){
                        arrayTextoDescriptografado[i] = arrayTextoOriginal[i];
                    } else {
                        char newChar = (char) ((int)arrayTextoOriginal[i] - 3);
                        arrayTextoDescriptografado[i] = newChar;
                    }
            }
        }
        String textoDescriptografado =  new String(arrayTextoDescriptografado);

        return textoDescriptografado;
    }
}
