package Objetos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocais {

    private List<Local> locais = new ArrayList<>();

    public List<Local> getLocais() {
        return locais;
    }

    public void adicionar(Local local) {
        if (local == null)
            throw new IllegalArgumentException("O local não pode ser nulo.");

        if (local.getNome() == null || local.getNome().isBlank())
            throw new IllegalArgumentException("O nome do local é obrigatório.");

        if (nomeExiste(local.getNome()))
            throw new IllegalArgumentException("Já existe um local com esse nome.");

        locais.add(local);
    }

    public void remover(int index) {
        if (index < 0 || index >= locais.size())
            throw new IllegalArgumentException("Índice inválido.");
        locais.remove(index);
    }

    public void substituir(int index, Local novoLocal) {
        if (index < 0 || index >= locais.size())
            throw new IllegalArgumentException("Índice inválido.");

        if (novoLocal == null)
            throw new IllegalArgumentException("O local não pode ser nulo.");

        if (novoLocal.getNome() == null || novoLocal.getNome().isBlank())
            throw new IllegalArgumentException("O nome do local é obrigatório.");

        // Verifica se o novo nome já existe (mas permite manter o mesmo nome)
        for (int i = 0; i < locais.size(); i++) {
            if (i == index) continue;
            if (locais.get(i).getNome().equalsIgnoreCase(novoLocal.getNome()))
                throw new IllegalArgumentException("Já existe outro local com esse nome.");
        }

        locais.set(index, novoLocal);
    }

    private boolean nomeExiste(String nome) {
        return locais.stream()
                .anyMatch(l -> l.getNome().equalsIgnoreCase(nome));
    }
}
