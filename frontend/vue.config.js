const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

  // ESLint false -> 단일 단어 컴포넌트 사용 가능
  lintOnSave: false,
  outputDir: "../src/main/resources/static", //빌드 타겟 디렉토리
  // npm run serve 개발 진행시에 포트가 다르기때문에 프록시 설정
  devServer: {
    proxy: 'http://localhost:8081'
  }

});


