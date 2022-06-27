<template>
    <v-card outlined>
        <v-card-title>
            Community # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <User offline label="User" v-model="item.user" :editMode="false" @change="change" />
            <Photo offline label="Photo" v-model="item.photo" :editMode="false" @change="change" />
            <Address offline label="Address" v-model="item.address" :editMode="false" @change="change" />
            <div>
                <String label="Title" v-model="item.title" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Content" v-model="item.content" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Category" v-model="item.category" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'CommunityDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/communities/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
        },
    };
</script>
