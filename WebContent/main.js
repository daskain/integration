function clickAddTr(){ //добавить строку перед таблицей
	var newTr = document.querySelector('.newTr').cloneNode(true);
	document.querySelector('.tBody').insertBefore(newTr,document.querySelector('.butTr'));
	
};
function clickDelTr(){//удалить последнюю строку
	
}