<template>

    <v-data-table
            :headers="headers"
            :items="user"
            :items-per-page="5"
            class="elevation-1"
    ></v-data-table>

</template>

<script>

    export default {
        name: 'UserList',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { 
                    text: "id", 
                    value: "id" 
                },
                { 
                    text: "password", 
                    value: "password" 
                },
                { 
                    text: "name", 
                    value: "name" 
                },
                { 
                    text: "email", 
                    value: "email" 
                },
                { 
                    text: "address", 
                    value: "address" 
                },
                { 
                    text: "phone", 
                    value: "phone" 
                },
            ],
            user : [],
        }),
        async created() {
            if(!this.value) this.value = [];
        },
        methods: {
        }
    }
</script>

