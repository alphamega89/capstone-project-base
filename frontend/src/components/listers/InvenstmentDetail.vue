<template>
    <v-card outlined>
        <v-card-title>
            Invenstment # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <Photo offline label="Photo" v-model="item.photo" :editMode="false" @change="change" />
            <User offline label="User" v-model="item.user" :editMode="false" @change="change" />
            <Money offline label="Money" v-model="item.money" :editMode="false" @change="change" />
            <div>
                <String label="InvestName" v-model="item.investName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="SaleInfo" v-model="item.saleInfo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="InvestInfo" v-model="item.investInfo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="WorkInfo" v-model="item.workInfo" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'InvenstmentDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/invenstments/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
        },
    };
</script>
