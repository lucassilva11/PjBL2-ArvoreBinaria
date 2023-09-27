package arvoreBinaria;

public class ArvoreBinaria {
	private Node raiz;

	public void incluir(int info) {
		Node novo = new Node();
		novo.setInfo(info);
		
		if(raiz == null)
			raiz = novo;
		else {
			Node atual = raiz;
			
			Node noAnterior = new Node();
			
			while(true) {
				//atualiza a referência do nó anterior
				noAnterior = atual;
				//se o dado for menor que o valor do nó atual
				if(info < atual.getInfo()) {
					atual = atual.getEsquerda();
					if(atual == null) {
						noAnterior.setEsquerda(novo);
						return;
					}
				//se o dado for maior que o valor do nó atual
				}else {
					atual = noAnterior.getDireita();
					if(atual == null) {
						noAnterior.setDireita(novo);
						return;
					}
				}
			}	
		}
	}
	
	public Node remover(int info, boolean trueInfo) {
		boolean existe = buscar(info);
		
		if(existe) {
		    if(raiz == null) {
		    	System.out.println("A raiz é nula!");
		        return raiz;
		    }
		    
			Node atual = raiz;
			Node noAnterior = raiz;
			//esquerda = true e direita = false
	        boolean verificador = true;
		
	        while (atual.getInfo()!= info){
	        	noAnterior = atual;
	            if(info < atual.getInfo()){
	                atual = atual.getEsquerda();
	                verificador = true;
	            }else{
	                atual = atual.getDireita();
	                verificador = false;
	            }
	            if(atual == null) {
	            	System.out.println("O valor removido foi: "+info);
	                return raiz;
	            }
	        }
	        //caso o dado seja folha
	        if(atual.getEsquerda() == null && atual.getDireita() == null){
	            if(atual == raiz)
	                raiz = null;
	            else if(verificador)
	            	noAnterior.setEsquerda(null);
	            else
	            	noAnterior.setDireita(null);
	        }
	        // se a folha for menor q o nó anterior ele fica na esquerda do nó anterior, se for maior fica na direita
	        else if(atual.getDireita() == null) {
	        	if(noAnterior.getInfo() > atual.getEsquerda().getInfo())
	        		noAnterior.setEsquerda(atual.getEsquerda());
	        	else	
	        		noAnterior.setDireita(atual.getEsquerda());
	        
	        } else if(atual.getEsquerda() == null) {
	        	if(noAnterior.getInfo() > atual.getDireita().getInfo())
	        		noAnterior.setEsquerda(atual.getDireita());
	        	else	
	        		noAnterior.setDireita(atual.getDireita());
	        //caso o nó tenha esquerdo e direito
	        }else {
	        	Node node = atual;
	        	Node menorDireita = atual.getDireita();
	        	while(menorDireita != null) {
	        		//encontra o valor que vai substituir o valor removido
	        		node = menorDireita;
	        		menorDireita = menorDireita.getEsquerda();
	        	}
	        	//remove o dado na direita, pois ele vai substituir o valor removido
	        	remover(node.getInfo(), false);
	        	atual.setInfo(node.getInfo());
	        	
	        	
	        }
	        
		}else{
			System.out.println("O número informado não faz parte da árvore!");
		}
		if(trueInfo) 
			System.out.println("O valor removido foi: " + info);
		return raiz;
		
	}
	
	public boolean buscar(int info) {
		Node atual = raiz;
		Node noAnterior = new Node();
		
		if(raiz == null)
			return false;
		
		while(true) {
			noAnterior = atual;
			if(info == atual.getInfo()) {
				return true;
			}else if(info < atual.getInfo()) {
				atual = atual.getEsquerda();
				if(atual == null) {
					return false;
				}
			}else if(info > atual.getInfo()) {
				atual = noAnterior.getDireita();
				if(atual == null) {
					return false;
				}
			}else {
				return false;
			}
		}
	}
	
	public Node getRaiz() {
		return raiz;
	}

	public void setRaiz(Node raiz) {
		this.raiz = raiz;
	}
}
