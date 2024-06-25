import {
	Create,
	required,
	SimpleForm,
	TextInput,
	useCreate,
	useRedirect,
} from 'react-admin'

export const UserCreate = () => {
	const [create] = useCreate()

	const onCreate = (data: unknown) => {
		create('users', {data: [data]})
	}

	const redirect = useRedirect()

	const onSuccess = () => {
		redirect(`/reviews`)
	}

	return (
		<Create mutationOptions={{onSuccess}}>
			<SimpleForm onSubmit={onCreate}>
				<TextInput source='username' validate={[required()]} label='Username' />
				<TextInput source='email' validate={[required()]} label='Email' />
				<TextInput
					source='first_name'
					validate={[required()]}
					label='First Name'
				/>
				<TextInput
					source='last_name'
					validate={[required()]}
					label='Last Name'
				/>
			</SimpleForm>
		</Create>
	)
}
