import {Datagrid, EditButton, List, TextField} from 'react-admin'

export const UsersList = () => (
	<List>
		<Datagrid rowClick='show'>
			<TextField source='id' />
			<TextField source='username' />
			<TextField source='email' />
			<TextField source='first_name' />
			<TextField source='last_name' />
			<EditButton label='Edit' />
		</Datagrid>
	</List>
)
