classDiagram
        
        class Menu{
            -boolean:modoEscuro
            +boolean:isModoEscuro()
            +Menu()
            +int:processaToken(int:i, int:j)
            +void:setModoEscuro(boolean:modoEscuro)
            +ArrayList<Usuario>:carregaLogins()
            +Usuario:efetuaLogin(ArrayList<Usuario>: usuarios)
            +void:criaPersonagem(Usuario:usuarioAtual)
        }
        class CrudLocais{
            -RepositorioLocais:repositorio
            -Scanner:sc
            +CrudLocais(RepositorioLocais:repositor)
            +void:executar()
            +void:listar()
            +void:adicionar()
            +void:editar()
            +void:remover()
            -Local:criarLocalPorTipo(String:nome, String:desc)
        }
        
        class Usuario{
            -ArrayList<Personagem>: personagensDoUsuario
        }

        class Personagem{
            -String: nome
            -Arquetipo: arquetipo
            -int:sociabilidade
            -Trabalho:trabalho
            -HashMap<String, Integer>:relacionamento
            +Personagem(String:nome, int:arquetipo)
            +Arquetipo:getArquetipo()
            +String:getNome()
            +int:getSociabilidade()
            +Trabalho:getTrabalho()
            +void:setArquetipo(int:arquetipo)
            +void:setNome(String:nome)
            +void:setSociabilidade()
            +void:setTrabalho(Trabalho:trabalho)
            +void:exibeFicha()
            +void:alteraNome(Usuario:usuarioAtualç)
            +void:alteraArquetipo()
            +void:alteraTemaAcademico(PersonagensGerais:personagem)
            +void:setTemaAcademico(int:novoTema)
        }
        class ILocal{
            <<Interface>>
            void:adicionar(Local:local)
            Local:obter(int:indice)
            void:remover(int:indice)
            int:tamanho()
            ArrayList<Local>:obterTodos
            void:substituir(int:indice, Local:novoLocal)
        }
        class Local{
            <<abstract>>
            -String:nome
            -String:descricao
            +Local(String:nome, String:descricao)
            +String:getNome()
            +void:setNome(String:nome)
            +abstract:void:interagirSozinho(PersonagensGerais:p)
            +abstract:void:interagir2Personagens(PersonagensGerais:p1, PersonagensGerais:p2)
            +abstract:void:interagir3Personagens(PersonagensGerais:p1, PersonagensGerais:p2, PersonagensGerais:p3)

        }
        class LocalBarulhento{
            -static:final:Random:r
            +LocalBarulhento(String:nome, String:descricao)
            +void:interagirSozinho(PersonagensGerais:p)
            +void:interagir2Personagens(PersonagensGerais:p1, PersonagensGerais:p2)
            +void:interagir3Personagens(PersonagensGerais:p1, PersonagensGerais:p2, PersonagensGerais:p3)
        }
        class LocalChatissimo{
            -static:final:Random:r
            +LocalChatissimo(String:nome, String:descricao)
            +void:interagirSozinho(PersonagensGerais:p)
            +void:interagir2Personagens(PersonagensGerais:p1, PersonagensGerais:p2)
            +void:interagir3Personagens(PersonagensGerais:p1, PersonagensGerais:p2, PersonagensGerais:p3)
        }
        class LocalQuieto{
            -static:final:Random:r
            +LocalQuieto(String:nome, String:descricao)
            +void:interagirSozinho(PersonagensGerais:p)
            +void:interagir2Personagens(PersonagensGerais:p1, PersonagensGerais:p2)
            +void:interagir3Personagens(PersonagensGerais:p1, PersonagensGerais:p2, PersonagensGerais:p3)
        }
        class LocalRomantico{
            -static:final:Random:r
            +LocalRomantico(String:nome, String:descricao)
            +void:interagirSozinho(PersonagensGerais:p)
            +void:interagir2Personagens(PersonagensGerais:p1, PersonagensGerais:p2)
            +void:interagir3Personagens(PersonagensGerais:p1, PersonagensGerais:p2, PersonagensGerais:p3)
        }
        class LocalTreino{
            -static:final:Random:r
            +LocalRomantico(String:nome, String:descricao)
            +void:interagirSozinho(PersonagensGerais:p)
            +void:interagir2Personagens(PersonagensGerais:p1, PersonagensGerais:p2)
            +void:interagir3Personagens(PersonagensGerais:p1, PersonagensGerais:p2, PersonagensGerais:p3)
        }
        class Estudante{
            -static:final:long:serialVersionUID
            -Interesses:interesses
            +Estudante(int:interesses, String:nome, int:arquetipo)
            +void:setInteresses(int:interesses)
            +Interesses:getInteresses()
            +void:setTemaAcademico(int:novoTema)
            +void:exibeFicha()
        }
        class LogicaJogo{
            -static:Random:random
            +static:void:executarJogo(ArrayList<PersonagensGerais>:arrayPersonagens, RepositorioLocais:locais)
            +static:int:selecionarEvento(ArrayList<PersonagensGerais>:arrayPersonagens)
            +static:Local:sellecionaLocal(RepositorioLocais:repositorioLocais)
            +static:void:selecionarModo(int:repeticoes, ArrayList<PersonagensGerais>:arrayPersonagens, RepositorioLocais:locais)
            +static:void:limparTerminal()
        }
        class Professor{
            -Area:area
            +Professor(int:area, String:nome, int:arquetipo)
            +void:setArea(int:area)
            +Area:getArea()
            +void:setTemaAcademico(int:novoTema)
            +void:exibeFicha()
        }
        class Arquetipo{
            <<enumeration>>
            ESTUDIOSO,
            AMNESICO,
            HERDEIRO,
            EREMITA,
            ATLETA,
            OPERARIO,
            CONSELHO_ESTUDANTIL,
            ARTISTA,
            DELINQUENTE,
            SOLITARIO,
            RELIGIOSO,
            POTENCIA,
            PESO_MORTO,
            POPULAR,
            CAPETA,
            OBSTINADO,
            SORTUDO,
            VILAO,
            GENERICA
        }
        class Interesses{
            <<enumeration>>
            ARTES_MARCIAIS,
            ASTROLOGIA,
            HONKAI,
            HISTORIA,
            INVESTIMENTOS
        }
        class Area{
            <<enumeration>>
            LUTA,
            PORTUGUES,
            LINGUA_ESTRANGEIRA,
            ESTRATEGIA,
            HISTORIA
        }
        class Pessoa{
            +Pessoa(String:nome, int:arquetipo, int:sociabilidade, Trabalho:trabalho)  
        }
        class RepositorioLocais{
            -List<Local>:locais
            +List<Local>:getLocais()
            +void:adicionar(Local:local)
            +void:remover(int:index)
            +void:subistituir(int:index, Local:novoLocal)
            -boolean:nomeExiste(String:nome)
        }
        class Trabalho{
            <<enumeration>>
            ESTUDANTE,
            PROFESSOR,
            COZINHEIRO,
            ZELADOR,
            COORDENADOR,
            ENFERMEIRO,
            EXTRA
        }
        class Usuario{
            -static:final:long:serialVersionUID
            -String:login
            -String:senha
            -ArrayList<PersonagensGerais>:personagens
            -RepositorioLocais:locais
            +Usuario(String:login, String:senha)
            +void:setlogin(String:login)
            +void:setSenha(String:senha)
            +String:getLogin()
            +void:setLocais(RepositorioLocais:locais)
            +RepositorioLocais:getLocais()
            +ArrayList<PersonagensGerais>:getPersonagens()
            +void:addPersoinLista(Personagem:personagem)
            +void:imprimePersonagens()
            +void:imprimeLogin()
            +boolean:verificaLogin(String:teste)
            +boolean:verificaSenha(String:teste)
            +void:modificarSenha()
            +void:modificarLogin()
            +boolean:verificaExistenciaNome(String:nome)
            +boolean:isEstudante(int:index)
            +void:alteraListaPersonagens(int:alteracao, int:index)
        }
        class PersonagensGerais{
            <<Interface>>
            void:exibeFicha();
            String:getNome();
            Trabalho:getTrabalho();
            void:alteraNome(Usuario:usuarioAtual);
            void:alteraArquetipo();

            void:setTemaAcademico(int:novoTema);

            void:alteraTemaAcademico(PersonagensGerais:personagem);
        }
        
        Menu..>Usuario
        CrudLocais-->RepositorioLocais
        CrudLocais..>Local
        Estudante-->Interesses
        Personagem<|--Estudante
        Personagem<|--Professor
        Personagem<|--Pessoa
        PersonagensGerais<|..Personagem
        Local..>PersonagensGerais
        Local<|--LocalBarulhento
        Local<|--LocalChatissimo
        Local<|--LocalQuieto
        Local<|--LocalRomantico
        Local<|--LocalTreino
        LogicaJogo..>PersonagensGerais
        LogicaJogo..>RepositorioLocais
        Personagem-->Arquetipo
        Personagem-->Trabalho
        Personagem..>Arquetipo
        Personagem..>Trabalho
        Personagem..>Usuario
        Personagem..>PersonagensGerais
        PersonagensGerais..>Trabalho
        PersonagensGerais..>Usuario
        PersonagensGerais..>PersonagensGerais
        Professor..>Area
        RepositorioLocais-->Local
        Usuario-->PersonagensGerais
        Usuario..>RepositorioLocais
        Usuario..>PersonagensGerais
