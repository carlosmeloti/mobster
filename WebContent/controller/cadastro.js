var cadAluModulo = angular.module('cadAluModulo',[]);

cadAluModulo.controller("cadAluController", function($scope, $http){
	
	
	urlAlunos = 'http://qosdesenvolvimentos.com.br/Mobster/rest/cadastros';
	
	
	
	$scope.listarAlunos = function() {
		$http.get(urlAlunos).success(function (alunos) {
			$scope.cadastrosAlunos = alunos;
		}).error (function(erro) {
			alert(erro);
		}); 
	}
	
	
	

	$scope.selecionaAluCol = function(cadAluSelecionado) {
		$scope.cadastro = cadAluSelecionado;

	}

	$scope.limparCampos = function(){
		$scope.cadastro = "";
	}

	$scope.carregarCatalogo = function(){
		location.href="parabens.html";
	}
	
	
	$scope.salvar = function(){
		if ($scope.cadastro.id == undefined) {
			$http.post(urlAlunos, $scope.cadastro).success(function(alunos){
				$scope.limparCampos();
				$scope.listarAlunos();
				alert("Cadastrado!");
				$scope.carregarCatalogo();
			}).error (function(erro) {
				alert(erro);
			}); 
				
	} else {
		$http.put(urlAlunos, $scope.cadastro).success(function(alunos){
			$scope.listarAlunos();
			$scope.limparCampos();
		}).error (function(erro) {
			alert(erro);
		}); 
		
	}
	}
	
	$scope.excluir = function() {
		if ($scope.cadastro.id == undefined) {
			alert("Favor selecionar um registro");
			console.log("Favor selecionar um registro");
		
	}else{ 
		$http.delete(urlAlunos+'/'+$scope.cadastro.id).success(function() {
			$scope.listarAlunos();
			$scope.limparCampos();
		}).error (function(erro) {
			alert(erro);
		}); 
	}
	}
	
	//Executa
	$scope.listarAlunos();

});