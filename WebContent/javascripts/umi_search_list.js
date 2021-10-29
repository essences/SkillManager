$(function() {

    // 初期状態で検索条件にカーソルを当てる
    $('#searchJoken-input-text').focus();

    $('.detail-button').click(function(){
        // 詳細画面を立ち上げる
        window.open('Jukou?shainNo='+this.dataset.key, 'detailWindow'+this.dataset.key, 'width=800, height=700, scrollbars=yes');
    });


    $('.sankashalist-button').click(function(){
        // 詳細画面を立ち上げる
        window.open('Sankasha?KENSHUJISSEKIID='+this.dataset.key, 'detailWindow'+this.dataset.key, 'width=1000, height=700, scrollbars=yes');
    });

});


function allchecktrue()
{
    var elementsCount = document.searchForm.elements.length;
    for( i=0 ; i<elementsCount ; i++ )
    {
        document.searchForm.elements[i].checked = true;
    }
}

function allchecktrue2()
{
   var elementsCount = document.searchForm.elements.length;
    for( i=0 ; i<elementsCount ; i++ )
    {
		if(document.searchForm.elements[i].name == 'deleleCkecbox')
		{ continue; }
        document.searchForm.elements[i].checked = true;
    }
}

function allcheckfalse()
{
    var elementsCount = document.searchForm.elements.length;
    for( i=0 ; i<elementsCount ; i++ )
    {
		if(document.searchForm.elements[i].name == 'check_type')
		{ continue; }


        document.searchForm.elements[i].checked = false;
    }
}
function allcheck(tf)
  {
      var elementsCount = document.searchForm.elements.length;
      for( i=0 ; i<elementsCount ; i++ )
      {
          document.searchForm.elements[i].checked = tf;
      }
  }


function changeCell(){
    if(document.searchForm.check_type.checked != true){
        var e=document.getElementsByTagName('*');
        for (var i = 0; i < e.length; i++){
            if(e[i].className == 'noneLine'){
                e[i].style.display = 'none';
            }
        }
    }else{
        var e=document.getElementsByTagName('*');
        for (var i = 0; i < e.length; i++){
            if(e[i].className == 'noneLine'){
                e[i].style.display = '';
            }
        }
    }
}


function changeCell(className){
    if(document.searchForm.check_type.checked != true){
        var e = getElementsByClass(className);
        for (var i = 0; i < e.length; i++){
            e[i].style.display = 'none';
        }
    }else{
        var e = getElementsByClass(className);
        for (var i = 0; i < e.length; i++){
            e[i].style.display = '';
        }
    }
    if(document.searchForm.check_type.checked == true){
        var e = getElementsByClass("alt"+ className);
        for (var i = 0; i < e.length; i++){
            e[i].style.display = 'none';
        }
    }else{
        var e = getElementsByClass("alt"+ className);
        for (var i = 0; i < e.length; i++){
            e[i].style.display = '';
        }
    }
}

// 参照 http://blog.livedoor.jp/nipotan/archives/15424695.html
function getElementsByClass(searchClass) {
    var classElements = new Array();
    var allElements = document.getElementsByTagName("*");
    for (i = 0, j = 0; i < allElements.length; i++) {
        if (allElements[i].className == searchClass) {
            classElements[j] = allElements[i];
            j++;
        }
    }
    return classElements;
}

function init()
{
    var e = getElementsByClass('noneLine');
    for (var i = 0; i < e.length; i++){
        e[i].style.display = 'none';
    }
}

function getSelected(){
    // 値(数値)を取得
    var num = document.searchForm.kenshuList.selectedIndex;

    // 値(value値)を取得
    return  document.searchForm.kenshuList.options[num].value;

}
