/*
* 单个删除
* */
function DeleteOne() {
    $("#mainForm").attr("action","/DeleteOneAction");

    $("#mainForm").submit();
}
/*
* 批量删除;
* */
function DeleteBatch() {
    $("#mainForm").attr("action","/DeleteBatchAction");
    $("#mainForm").submit();
}