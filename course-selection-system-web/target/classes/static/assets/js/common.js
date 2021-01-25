document.write('<!-----------  公共js和css start----------->');
document.write('' +
    '<link rel="icon" th:href="@{/images/favicon.ico}">\n' +
    '<link rel="stylesheet" th:href="@{/assets/css/vendors_css.css}">\n' +
    '<link rel="stylesheet" th:href="@{/assets/css/style.css}">\n' +
    '<link rel="stylesheet" th:href="@{/assets/css/skin_color.css}">\n' +
    '<script th:src="@{/assets/js/vendors.min.js}"></script>\n' +
    '<script th:src="@{/assets/vendor_components/easypiechart/dist/jquery.easypiechart.js}"></script>' +
    '<script th:src="@{/assets/icons/feather-icons/feather.min.js}"></script>\n' +
    '<script th:src="@{/assets/vendor_components/apexcharts-bundle/irregular-data-series.js}"></script>\n' +
    '<script th:src="@{/assets/vendor_components/apexcharts-bundle/dist/apexcharts.js}"></script>\n' +
    '<script th:src="@{/assets/js/template.js}"></script>\n' +
    '<script th:src="@{/assets/js/pages/dashboard.js}"></script>' +
    '');
document.write('<!-----------  公共js和css end----------->');