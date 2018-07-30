$(function() {

    // 初期状態で検索条件にカーソルを当てる
    $('#searchJoken-input-text').focus();

    $('.detail-button').click(function(){
        // 詳細画面を立ち上げる
        window.open('Jukou?shainNo='+this.dataset.key, 'detailWindow'+this.dataset.key, 'width=800, height=700, scrollbars=yes');
    });

});

function test()
{
  alert('testアラート');
}
function allchecktrue()
{
    var elementsCount = document.searchForm.elements.length;
    for( i=0 ; i<elementsCount ; i++ )
    {
        document.searchForm.elements[i].checked = true;
    }
}
function allcheckfalse()
{
    var elementsCount = document.searchForm.elements.length;
    for( i=0 ; i<elementsCount ; i++ )
    {
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