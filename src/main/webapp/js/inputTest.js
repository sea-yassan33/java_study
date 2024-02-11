// フォームが送信された時にURLを作成してリダイレクトする
$("#myForm").submit(function(event){
    event.preventDefault(); //フォームのデフォルトの動作をキャンセル

    var selectedOption = $("#selectedOption").val();
    var redirectUrl = "/SampleEnv/TargetServlet?selected=" + selectedOption;
    window.location.href = redirectUrl; // リダイレクト
});