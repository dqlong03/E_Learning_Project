<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Read Excel in HTML</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.16.9/xlsx.full.min.js"></script>
    </head>
    <body>
        <form method="post" action="dashboard/readFiled">
            <input type="file" id="excel-file" accept=".xlsx, .xls" onchange="handleFile(this.files)">
            <div id="questions-list"></div>
            <button type="submit">Save</button>
        </form>
        <c:if test="${not empty requestScope.questions}">
            <c:forEach items="${requestScope.questions}" var="q" >
                ${q.content}
                <br>
                <c:forEach items="${requestScope.answers}" var="a" >
                    <c:if test="${a.question.questionId==q.questionId}">
                        ${a.content} : ${a.isTrue}
                        <br>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </c:if>
        <br>
        <button onclick="exportToExcel()">Download</button>




        <script>
            function exportToExcel() {
                var data = [
                    ["Question ", "Answer 1", "IsTrue 1", "Answer 2", "IsTrue 2", "Answer 3", "IsTrue 3", "Answer 4", "IsTrue 4", "Answer 5", "IsTrue 5", "Answer 6", "IsTrue 6"],
                ];

                var ws = XLSX.utils.aoa_to_sheet(data);
                var wb = XLSX.utils.book_new();
                XLSX.utils.book_append_sheet(wb, ws, "Sheet1");
                var wbout = XLSX.write(wb, {bookType: 'xlsx', type: 'binary'});

                function s2ab(s) {
                    var buf = new ArrayBuffer(s.length);
                    var view = new Uint8Array(buf);
                    for (var i = 0; i < s.length; i++)
                        view[i] = s.charCodeAt(i) & 0xFF;
                    return buf;
                }

                var blob = new Blob([s2ab(wbout)], {type: "application/octet-stream"});
                var url = URL.createObjectURL(blob);

                var a = document.createElement("a");
                a.href = url;
                a.download = "Template_Input_Question.xlsx";
                document.body.appendChild(a);
                a.click();
                setTimeout(function () {
                    document.body.removeChild(a);
                    window.URL.revokeObjectURL(url);
                }, 0);
            }
        </script>
        <script>
            function handleFile(files) {
                const file = files[0];
                const reader = new FileReader();

                reader.onload = function (event) {
                    const data = new Uint8Array(event.target.result);
                    const workbook = XLSX.read(data, {type: 'array'});
                    const sheetName = workbook.SheetNames[0];
                    const sheet = workbook.Sheets[sheetName];
                    const excelData = XLSX.utils.sheet_to_json(sheet, {header: 1});

                    const questions = parseExcelData(excelData);
                    displayQuestions(questions);
                };

                reader.readAsArrayBuffer(file);
            }

            function parseExcelData(data) {
                const questions = [];
                data.forEach(function (row, rowIndex) {
                    if (rowIndex > 0) {
                        const question = row[0];
                        const answers = [];
                        const isTrue = [];
                        for (let i = 1; i < row.length; i += 2) {
                            const answer = row[i];
                            const isTrueValue = row[i + 1];
                            if (answer !== null && answer !== undefined) {
                                answers.push(answer);
                            }
                            if (isTrueValue !== null && isTrueValue !== undefined) {
                                isTrue.push(isTrueValue);
                            }
                            if (answers.length > 6)
                                break;
                        }
                        if (answers.length >= 2 && answers.length <= 6 && answers.length === isTrue.length) {
                            questions.push({question, answers, isTrue});
                        }
                    }
                });

                return questions;
            }

            function displayQuestions(questions) {
                const questionsListDiv = document.getElementById('questions-list');
                questionsListDiv.innerHTML = '';

                questions.forEach(function (questionObj, index1) {
                    const questionDiv = document.createElement('div');
                    const questionHeader = document.createElement('input');
                    questionHeader.setAttribute('value', questionObj.question);
                    questionHeader.setAttribute('name', 'question_' + index1);
                    questionHeader.setAttribute('type', 'hidden');
                    questionHeader.textContent = questionObj.question;
                    questionDiv.appendChild(questionHeader);

                    const answersList = document.createElement('div');
                    questionObj.answers.forEach(function (answer, index) {
                        const answerText = document.createElement('input');
                        answerText.setAttribute('name', 'answer_' + index1 + '_' + index);
                        answerText.setAttribute('value', answer);
                        answerText.setAttribute('type', 'hidden');
                        answerText.textContent = answer;
                        answersList.appendChild(answerText);
                        const istrue = document.createElement('input');
                        istrue.setAttribute('name', 'istrue_' + index1 + '_' + index);
                        istrue.setAttribute('value', questionObj.isTrue[index]);
                        istrue.setAttribute('type', 'hidden');
                        istrue.textContent = 'Is True: ' + questionObj.isTrue[index];
                        answersList.appendChild(istrue);
                    });
                    questionDiv.appendChild(answersList);

                    questionsListDiv.appendChild(questionDiv);
                });
            }
        </script>
    </body>
</html>
