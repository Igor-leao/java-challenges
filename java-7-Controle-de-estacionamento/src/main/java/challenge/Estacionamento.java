package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Estacionamento {
    private List<Carro> litaCarros= new ArrayList<Carro>();
    private static final int numeroDeVagas = 10;

    public void estacionar(Carro carro) throws EstacionamentoException{
        if(motoristaPremitido(carro.getMotorista())) {
            if(litaCarros.size() == numeroDeVagas) {
                if(litaCarros.get(0).getMotorista().getIdade() > 55) {
                    Optional<Carro> carroQueSai = litaCarros.stream()
                            .filter(c -> c.getMotorista().getIdade() < 55)
                            .findFirst();
                    if(carroQueSai.isPresent()) {
                        litaCarros.remove(carroQueSai.get());
                        litaCarros.add(carro);
                    } else throw new EstacionamentoException("Não há vagas");
                } else {
                    litaCarros.remove(0);
                    litaCarros.add(carro);
                }

            } else if(litaCarros.size() < numeroDeVagas) litaCarros.add(carro);
        } else {
            throw new EstacionamentoException("Motorista sem permissão para estacionar.");
        }
    }

    public boolean motoristaPremitido(Motorista motorista) {
        if(motorista.getIdade() < 18
            || motorista.getHabilitacao() == " "
            || motorista.getPontos() > 20) {
            return false;
        } else return true;
    }

    public int carrosEstacionados() {
        return litaCarros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        if (litaCarros.stream().filter(c -> c.equals(carro)).collect(Collectors.toList()).size() > 0) {
            return true;
        }
        return false;
    }
}
