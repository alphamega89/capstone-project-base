
<template>
  <v-app id="inspire">


    <v-main>
        <div>
            <div style="font-size:20px; font-weight:500; text-align:center; margin-top: 50px; margin-bottom: -70px;">로그인</div>
            <v-card
                elevation="2"
                width="500"
                class="mx-auto"
                style="margin-top:100px; padding: 10px;"
            ><br><div style="font-size:25px; font-weight:700; text-align:center; margin-bottom:50px;"><p>아이디 로그인</p></div>
                <v-text-field
                    label="아이디 입력"
                    outlined
                    style="width:450px;"
                    class="mx-auto"
                    v-model="id"
                ></v-text-field>

                <v-text-field
                    label="비밀번호 입력"
                    password
                    outlined
                    type="password"
                    style="width:450px;"
                    class="mx-auto"
                    v-model="password"
                ></v-text-field>

                <div style="width:350px; margin-bottom:50px;" class="mx-auto">
                    <v-btn 
                        block
                        color="teal"
                        rounded
                        @click="login()"
                    >
                        <div style="font-size:20px; font-weight:700; text-align:center; color:white">로그인</div>
                    </v-btn>
                </div><br>
                <div style="font-size: 13px; font-weight: 400; text-align: center; margin-top: -20px;">다른 방식으로 로그인 <v-icon style="margin-top: -3px;">mdi-chevron-down</v-icon></div>
            </v-card>
        </div>

    </v-main>
  </v-app>
</template>

<script>

  export default {
    name: "Login",
    data: () => ({
        drawer: null,
        id: null,
        password: null
    }),
    methods: {
        login() {
            console.log(this.id + this.password)
            this.$http.get(`/logins/validate/${this.id}/${this.password}`).then(function (result){
                console.log(result)
            }).catch(error => console.log(error));
        }
    }
  }
</script>